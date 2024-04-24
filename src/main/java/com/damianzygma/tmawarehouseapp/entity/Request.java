package com.damianzygma.tmawarehouseapp.entity;

import com.damianzygma.tmawarehouseapp.util.RequestStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Long quantity;

    private RequestStatus requestStatus;

    private String comment;



}
