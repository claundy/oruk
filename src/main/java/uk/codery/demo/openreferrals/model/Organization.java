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
@Document(collection = "organizations")
public class Organization {
    
    @Id
    private String id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private String description;
    
    private String email;
    
    private String url;
    
    private String logo;
    
    private String uri;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}