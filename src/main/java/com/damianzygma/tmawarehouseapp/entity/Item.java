package com.damianzygma.tmawarehouseapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "itemgroup_id")
    private ItemGroup itemGroup;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Double price;

    private String status;

    private String storage;

    private String contact;

    @OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
    private Set<Request> requests = new HashSet<>();


}
