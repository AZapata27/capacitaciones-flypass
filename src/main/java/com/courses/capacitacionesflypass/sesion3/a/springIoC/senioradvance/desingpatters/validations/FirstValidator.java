package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.desingpatters.validations;

import com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.desingpatters.Payment;
import com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.desingpatters.PaymentValidator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class FirstValidator  implements PaymentValidator {

    @Override
    public boolean validatePayment(Payment payment) {
        return true;
    }
}

@Service
@Order(2)
class SecondValidator  implements PaymentValidator {

    @Override
    public boolean validatePayment(Payment payment) {
        return true;
    }
}

@Service
@Order(3)
class ThridValidator  implements PaymentValidator {

    @Override
    public boolean validatePayment(Payment payment) {
        return true;
    }
}

@Service
@Order(4)
class FourdValidator  implements PaymentValidator {

    @Override
    public boolean validatePayment(Payment payment) {
        return true;
    }
}
