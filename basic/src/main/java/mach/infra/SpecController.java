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
// @RequestMapping(value="/specs")
@Transactional
public class SpecController {

    @Autowired
    SpecRepository specRepository;

    @PutMapping("/specs/search/findByName")
    public Object findByName(@RequestBody SpecViewQuery query) {
        return specRepository.findByName(query.getName());
    }
}
