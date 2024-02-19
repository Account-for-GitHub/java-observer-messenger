package messenger.app.informer;

import messenger.app.repository.RepositoryWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;


@WebFluxTest(controllers = {InformerController.class})
class InformerControllerTest {
    @MockBean
    private RepositoryWrapper repositoryWrapper;

    @BeforeEach
    void beforeAll() {
        Mockito.when(repositoryWrapper.save(new Message())).thenReturn(new Message());
        Mockito.when(repositoryWrapper.findAll()).thenReturn(List.of(
                new Message("Message 1"),
                new Message("Message 2")
        ));
    }

    @Test
    void receiveMessageToSend(@Autowired WebTestClient client) {
        client.post()
                .uri("/")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"message\": \"Some message\"}")
                .exchange()
                .expectStatus().isOk();
    }
}