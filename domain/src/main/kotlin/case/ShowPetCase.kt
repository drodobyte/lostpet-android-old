package case

import drodobyte.core.model.Id
import entity.Pet
import io.reactivex.Maybe
import service.PetService

class ShowPetCase(service: PetService) : Case(service) {

    fun show(id: Id): Maybe<Pet> = service.pet(id)
}
