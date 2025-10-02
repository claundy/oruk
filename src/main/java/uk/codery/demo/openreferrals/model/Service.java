package uk.codery.demo.openreferrals.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "services")
public class Service {
    
    @Id
    private String id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private String description;
    
    private String url;
    
    private String email;
    
    private String status;
    
    @DBRef
    private Organization organization;
    
    @DBRef
    private Location location;

    @DBRef
    private Set<Taxonomy> taxonomies;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}