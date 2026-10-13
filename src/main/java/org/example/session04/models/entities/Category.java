package org.example.session04.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories",schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 100)
    private String name;

//    @OneToMany(mappedBy = "category")
//    private List<Product> products;

    /*
        Category {
            id
            name
            products: [
                {
                    id
                    name
                    price
                    stock
                    category: {
                        id
                        name
                        products: {
                            ...
                        }
                    }
                }
            ]
        }
    */
}
