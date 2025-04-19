package restaurant.billing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.billing.model.Staff;
import restaurant.billing.repository.StaffRepository;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    public Staff saveStaff(Staff staff)
    {
        return staffRepository.save(staff);
    }

    public List<Staff> getAllStaffs()
    {
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(Long id)
    {
        return staffRepository.findById(id);
    }

    public Boolean staffDeleteById(Long id)
    {
        Optional<Staff> op = staffRepository.findById(id);
        if (op.isPresent()) {
            staffRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }

}
