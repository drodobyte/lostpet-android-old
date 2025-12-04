package service

import drodobyte.core.model.Id
import drodobyte.core.model.asId
import drodobyte.core.model.newId
import drodobyte.core.model.replace
import entity.Location
import entity.Pet
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextLong


class MockPetService : PetService {

    override fun pets() = Observable.fromIterable(pets)

    override fun pet(id: Id) = Maybe.just(pets.single { it.id == id })

    override fun save(pet: Pet): Single<Pet> {
        if (pet.isNone)
            pets.add(pet.copy(id = newId))
        else
            pets.replace(pet)
        return Single.just(pets.single { it.id == pet.id })
    }

    private val pets: MutableList<Pet> by lazy {
        mutableListOf(
            aPet(1003),
            aPet(1007),
            aPet(1023),
            aPet(10263),
            aPet(10715),
            aPet(10822),
            aPet(10982),
            aPet(11172),
            aPet(11182)
        )
    }

    private fun aPet(id: Long) = Pet(
        id.asId, "name_$id", "description_$id",
        "https://images.dog.ceo/breeds/hound-afghan/n02088094_$id.jpg",
        nextBoolean(),
        Location(
            Date(System.currentTimeMillis() + nextLong(1000000)),
            nextDouble(10.0),
            nextDouble(10.0),
            nextDouble(10.0)
        )
    )
}
