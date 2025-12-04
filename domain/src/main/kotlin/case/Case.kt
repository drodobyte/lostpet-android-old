package case

import case.Checker.Error
import drodobyte.core.util.Check.OnError
import entity.Pet
import service.PetService

/**
 * Base Use-Case class
 */
abstract class Case(val service: PetService) {

    fun check(pet: Pet): OnError<Error> =
        Checker.on(pet)
}
