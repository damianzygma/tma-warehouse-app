package com.damianzygma.tmawarehouseapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "items", schema = "tmawarehouseapp")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Double price;

    private String Status;

    @OneToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    private String contact;


}
