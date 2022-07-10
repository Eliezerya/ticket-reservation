package com.challange_4.apichallange4;

import com.challange_4.apichallange4.Controller.CostumerController;
import com.challange_4.apichallange4.Dto.CostumerDto;
import com.challange_4.apichallange4.Service.CostumerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock //pengganti autowired
    CostumerService usersService;
    @InjectMocks
    private CostumerController usersController;
    @Mock
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    WebApplicationContext context;

    @BeforeEach
        //jika terdapat annotation test maka BeforeEach akan dijalankan terlebih dahulu sebelum yang lainnya
    void setUp(){
        MockMvc mockMvc = MockMvcBuilders.
                webAppContextSetup(context)
                .alwaysDo(print())
                .apply(SecurityMockMvcConfigurers.springSecurity(springSecurityFilterChain))
                .build();
    }
    public CostumerDto getUsers(){
        CostumerDto customer = new CostumerDto(1, "useres", "xxx@gmail.com", "east");
        return customer;
    }

    @Test //Create test
    public void CustomerSaveTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(usersService.save_users(any(CostumerDto.class))).thenReturn(true);
        ResponseEntity<Object> responseEntity = usersController.submit_users(getUsers());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        System.out.println("test Succesful");
    }

    @Test //Read test
    public void CustomerDisplayTest(){
        ResponseEntity<?> responseEntity = usersController.users_display_byID(getUsers().getIdUsers());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        System.out.println("test Succesful");
    }

    @Test //Read All test
    public void CustomerDisplayAllTest(){
        ResponseEntity<?> responseEntity = usersController.users_display();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        System.out.println("test Succesful");

    }

    @Test //update test
    public void CustomerUpdateTest()throws Exception{
        ResponseEntity<?> responseEntity = usersController.users_update_byID(1,getUsers());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        System.out.println("test Succesful");

    }

    @Test //delete test
    public void CustomerDeleteTest(){
        ResponseEntity<?> responseEntity = usersController.users_delete_byID(1);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        System.out.println("test Succesful");

    }
}
