package com.damianzygma.tmawarehouseapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    private String contact;

    @OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
    private List<Request> requests = new ArrayList<>();


}
