package uk.codery.demo.openreferrals.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "taxonomies")
public class Taxonomy {

    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;
}