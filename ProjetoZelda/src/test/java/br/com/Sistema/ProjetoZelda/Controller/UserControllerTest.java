package br.com.Sistema.ProjetoZelda.Controller;

import br.com.Sistema.ProjetoZelda.Model.UserModel;
import br.com.Sistema.ProjetoZelda.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void getAllUsers() throws Exception {
        List<UserModel> userList = Arrays.asList(new UserModel(), new UserModel());
        when(userRepository.findAll()).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders.get("/user"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{}, {}]"));

        verify(userRepository, times(1)).findAll();
    }

    @Test
    void addUser() throws Exception {
        String requestBody = "{\"nome\": \"NovoUsuario\", \"email\": \"novo@email.com\", \"senha\": \"novaSenha\"}";
        UserModel user = new UserModel(1L, "Fulano", "Fulano@gmail.com", "senhadificil");

        when(userRepository.save(any(UserModel.class))).thenReturn(user);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println("JSON Retornado: " + result.getResponse().getContentAsString());

        verify(userRepository, times(1)).save(any(UserModel.class));
    }
}
