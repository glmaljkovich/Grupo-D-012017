package grupod.desapp.unq.edu.ar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabriel on 05/06/17.
 */
@RestController
abstract class LoggingController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

}
