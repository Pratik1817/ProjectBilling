package restaurant.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restaurant.billing.model.Staff;
import restaurant.billing.service.StaffService;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "http://localhost:5173")
public class StaffController {
    @Autowired
    StaffService staffService;

    @PostMapping
    ResponseEntity <Staff> addStaff(@RequestBody Staff staff)
    {
        return ResponseEntity.ok(staffService.saveStaff(staff));
    }

    @GetMapping
    ResponseEntity <List<Staff>> getStaff()
    {
        return ResponseEntity.ok(staffService.getAllStaffs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id)
    {
        Boolean b = staffService.staffDeleteById(id);
        if (b) {
            return ResponseEntity.ok("Staff deleted successfully...");
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }


}
