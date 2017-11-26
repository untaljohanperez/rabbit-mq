package udea.regalosnavidadapi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import udea.regalosnavidadapi.model.RabbitMessage;
import udea.regalosnavidadapi.model.Regalo;
import udea.regalosnavidadapi.rabbit.*;


@RestController
public class RegaloApiController {

    @Autowired
    Publisher publisher;

    @RequestMapping(method = RequestMethod.POST, path = "/regalo")
    public ResponseEntity<Regalo> crearRegalo(@RequestBody Regalo regalo) {
        publisher.publicarMensaje(new RabbitMessage("udea.regalos.regalovendido", regalo.getTipo(), regalo.getNombre()));
        return new ResponseEntity<Regalo>(regalo, HttpStatus.OK);
    }
}
