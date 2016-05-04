package com.fmdev.quoter;

import com.fmdev.quoter.annotation.DeprecatedClass;
import com.fmdev.quoter.annotation.InjectRandomInt;
import com.fmdev.quoter.annotation.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min=3, max=10)
    private int repeat;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    public TerminatorQuoter() {
        sayQuote();
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }
}
