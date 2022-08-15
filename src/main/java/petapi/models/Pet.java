package petapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
@AllArgsConstructor
@Data

public class Pet {
    private String petName;
    private int age;
    private String type;
    private String ownerName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Pet(){
        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }
    public Pet(String petName, int age, String type, String ownerName) {
        this.petName = petName;
        this.age = age;
        this.type = type;
        this.ownerName = ownerName;
        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }
}
