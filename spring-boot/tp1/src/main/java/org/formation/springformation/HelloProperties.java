package org.formation.springformation;

import org.formation.springformation.enumeration.CaseEnum;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Component
@ConfigurationProperties("hello")
@Validated
public class HelloProperties {

    @NotEmpty
    private String greeting;
    @Pattern(regexp = "UPPER|LOWER|CAMEL", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String styleCase;
    private CaseEnum style;
    @Range(min = 0, max = 1)
    private int position;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getStyleCase() {
        return styleCase;
    }

    public void setStyleCase(String styleCase) {
        this.styleCase = styleCase;
    }

    public CaseEnum getStyle() {
        return style;
    }

    public void setStyle(CaseEnum style) {
        this.style = style;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
