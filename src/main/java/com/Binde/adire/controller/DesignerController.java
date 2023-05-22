package com.Binde.adire.controller;
import com.Binde.adire.repository.DesignerRepository;
import com.Binde.adire.dto.request.UpdateDesigner;
import com.Binde.adire.dto.response.AppResponse;
import com.Binde.adire.dto.response.DesignerResponseDTO;
import com.Binde.adire.service.DesignerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/designer")
@RequiredArgsConstructor
public class DesignerController {
    private final DesignerRepository designerRepository;
    private final DesignerService designerService;
    private ModelMapper modelMapper = new ModelMapper();


    @GetMapping(path = "/getDesigner/{id}")
    public ResponseEntity<DesignerResponseDTO> getDesignerById(@PathVariable("id") String id){
        DesignerResponseDTO viewDesigner = designerService.getDesigner(id);
        return ResponseEntity.status(HttpStatus.OK).body(viewDesigner);
    }


    @PutMapping(path = "/updateDesigner")
    public ResponseEntity<Object> updateDesigner(@RequestBody UpdateDesigner request){
        DesignerResponseDTO updateDesigner = designerService.updateDesignerDetials(request);
        return ResponseEntity.ok().body(AppResponse.buildSuccessTxn(updateDesigner));
    }

    @GetMapping("/getDesignerInfo")
    public ResponseEntity<Object> getUserInfo(HttpServletRequest request) {
        DesignerResponseDTO userResponse = designerService.getDesignerProfile(request);
        return ResponseEntity.ok().body(userResponse);
    }

    @DeleteMapping(path = "/deleteDesigner/")
    public ResponseEntity<?> deleteDesigner(HttpServletRequest request){
        ResponseEntity<Object> responseEntity = getUserInfo(request);
        DesignerResponseDTO designerResponseDTO = (DesignerResponseDTO) responseEntity.getBody();
        designerService.deleteDesigner(designerResponseDTO.getEmail());
        return ResponseEntity.ok().body(AppResponse.buildSuccessTxn("Designer deleted successfully"));
    }




    }
