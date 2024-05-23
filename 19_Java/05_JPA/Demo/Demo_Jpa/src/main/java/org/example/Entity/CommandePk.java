package org.example.Entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class CommandePk  implements Serializable {
    private int code;
    private String nameCenter;

    public CommandePk() {
    }

    public CommandePk(int code, String nameCenter) {
        this.code = code;
        this.nameCenter = nameCenter;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameCenter() {
        return nameCenter;
    }

    public void setNameCenter(String nameCenter) {
        this.nameCenter = nameCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandePk that = (CommandePk) o;
        return code == that.code && Objects.equals(nameCenter, that.nameCenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, nameCenter);
    }
}
