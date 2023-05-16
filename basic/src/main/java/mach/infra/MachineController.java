package mach.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import mach.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/machines")
@Transactional
public class MachineController {

    @Autowired
    MachineRepository machineRepository;

    @PutMapping("/machines/search/findByCode")
    public Object findByCode(@RequestBody MachineViewQuery query) {
        return machineRepository.findByCode(query.getCode());
    }
}
