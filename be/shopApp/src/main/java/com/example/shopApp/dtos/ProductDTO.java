package com.example.shopApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotBlank(message = "title is required")
    @Size(min = 3, max = 100, message = "title must be between 3 and 200 character")
    private String name;

    @Size(min = 6, message = "description must be at least 6 character")
    private String description;

    @Min(value = 0, message = "price more 0")
    private long price;

    @NotNull(message = "thumbnail is required")
    private String thumbnail;

    @JsonProperty("category_id")
    private String categoryId;

}
