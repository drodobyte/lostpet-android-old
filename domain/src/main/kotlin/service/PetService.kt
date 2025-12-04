package service

import drodobyte.core.model.Id
import entity.Pet
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

interface PetService {

    fun pets(): Observable<Pet>

    fun pet(id: Id): Maybe<Pet>

    fun save(pet: Pet): Single<Pet>
}
