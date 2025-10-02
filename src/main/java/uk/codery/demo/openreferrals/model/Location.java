package uk.codery.demo.openreferrals.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "locations")
public class Location {
    
    @Id
    private String id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private String description;
    
    private Double latitude;
    
    private Double longitude;
    
    private String address1;
    
    private String address2;
    
    private String city;
    
    private String stateProvince;
    
    private String postalCode;
    
    private String country;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}