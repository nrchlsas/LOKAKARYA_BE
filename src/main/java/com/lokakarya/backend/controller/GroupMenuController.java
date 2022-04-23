package com.lokakarya.backend.controller;

import com.lokakarya.backend.service.GroupMenuService;
import com.lokakarya.backend.util.DataResponse;
import com.lokakarya.backend.util.DataResponseList;
import com.lokakarya.backend.wrapper.GroupMenuWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@RequestMapping (path = "/groupmenu")
public class GroupMenuController {
    @Autowired
    GroupMenuService groupMenuService;

      // get
      @GetMapping(path = "/findAll")
      DataResponseList<GroupMenuWrapper> findAll(){
          return new DataResponseList<GroupMenuWrapper>(groupMenuService.findAll());
      }
      @GetMapping(path = "/getById")
      DataResponse<GroupMenuWrapper> getById(@RequestParam("id") Long id){
          return new DataResponse<GroupMenuWrapper>(groupMenuService.getById(id));
      }
      @PostMapping(path= "/post")
      DataResponse<GroupMenuWrapper> post(@RequestBody GroupMenuWrapper wrapper){
          return new DataResponse<GroupMenuWrapper>(groupMenuService.save(wrapper));
      }
      @GetMapping(path = "/findByGroupId")
      DataResponseList<GroupMenuWrapper> findByGroup(@RequestParam("group") Long groupId){
          return new DataResponseList<GroupMenuWrapper>(groupMenuService.findByGroupId(groupId));
      }
      @GetMapping(path = "/findByGroupIdAndMenuId")
      DataResponse<GroupMenuWrapper> findByGroupAndMenu(@RequestParam("group") Long groupId, @RequestParam("menu") Long menuId){
          return new DataResponse<GroupMenuWrapper>(groupMenuService.findByGroupIdAndMenuId(groupId,menuId));
      } 
      @PutMapping(path = "/put")
      DataResponse<GroupMenuWrapper> update(@RequestBody GroupMenuWrapper wrapper){
          return new DataResponse<GroupMenuWrapper>(groupMenuService.save(wrapper));
      }
      @PutMapping(path = "/changeIsActive")
      DataResponse<GroupMenuWrapper> changeIsActive(@RequestParam("group") Long groupId, @RequestParam("menu") Long menuId){
          return new DataResponse<GroupMenuWrapper>(groupMenuService.changeIsActiveByGroupIdAndMenuId(groupId,menuId));
      } 
      @DeleteMapping(path = "/delete")
      DataResponse<GroupMenuWrapper> delete(@RequestParam("id") Long id){
          groupMenuService.delete(id);
          return new DataResponse<GroupMenuWrapper>(true, "Delete Sukses");
      }
}
