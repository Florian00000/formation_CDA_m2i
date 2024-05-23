package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
//@IdClass(CommandePk.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
//    @Id
//    private int code;
//    @Id
//    private String nameCenter;

//    @Id
//    private CommandePk pk;

    @EmbeddedId
    private CommandePk pk;
    private String date;
}
