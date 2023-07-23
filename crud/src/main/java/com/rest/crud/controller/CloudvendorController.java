package com.rest.crud.controller;

import com.rest.crud.model.CloudVendor;
import com.rest.crud.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudvendorController {
    //    private CloudVendor cloudVendor;
    CloudVendorService cloudVendorService;

    public CloudvendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

   // for reading specific cloud vendor
    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId ){
          return cloudVendorService.getCloudVendor(vendorId);

    }
    // for reading all cloud vendors
    @GetMapping()
    public List< CloudVendor>getCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();

    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud vendor created seccessfully";
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId")  String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted Successfully";
    }
}
