package com.maciej.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
class BaseEntity implements Serializable {

    private Long id;
}
