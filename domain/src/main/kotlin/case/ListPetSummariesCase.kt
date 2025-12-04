package case

import drodobyte.core.model.Id
import drodobyte.core.model.Model
import drodobyte.core.model.asId
import entity.Location
import entity.Pet
import entity.toPetSummary
import io.reactivex.Observable
import service.PetService

class ListPetSummariesCase(service: PetService) : Case(service) {

    fun listAllWithOneDummy(): Observable<PetSummary> {
        val pets = service.pets()
        return pets.isEmpty.flatMapObservable { empty ->
            if (empty)
                service.save(dummy).toObservable()
            else
                pets
        }.map(Pet::toPetSummary)
    }

    fun listFound(): Observable<PetSummary> =
        service.pets()
            .filter { it.found }
            .map(Pet::toPetSummary)

    fun listLost(): Observable<PetSummary> =
        service.pets()
            .filter { !it.found }
            .map(Pet::toPetSummary)

    data class PetSummary(
        override val id: Id?,
        val name: String = "",
        val imageUrl: String = ""
    ) : Model

    private val dummy = Pet(
        1.asId,
        "dummy",
        "dummy desc",
        "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg",
        false,
        Location()
    )
}
