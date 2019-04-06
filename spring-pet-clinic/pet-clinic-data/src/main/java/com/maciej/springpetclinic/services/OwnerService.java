package com.maciej.springpetclinic.services;

import com.maciej.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String name);


}
