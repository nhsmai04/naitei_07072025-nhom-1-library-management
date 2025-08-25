package org.librarymanagement.controller.admin;

import org.librarymanagement.constant.ApiEndpoints;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ApiEndpoints.ADMIN_BORROW_REQUEST)
public class BookRequestController {
   /* @GetMapping
    public String showRequestBook() {
        return "admin/borrow-requests/index";
    }

    @GetMapping("/{id}")
    public String showRequestBookedit() {
        return "admin/borrow-requests/detail";
    }*/
}
