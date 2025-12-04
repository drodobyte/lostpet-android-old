package entity

import drodobyte.core.model.Id
import drodobyte.core.model.Model

data class Pet(
    override val id: Id?,
    val name: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val found: Boolean = false,
    val location: Location = Location()
) : Model {
    val undefined
        get() = isNone && name == "" && description == "" && imageUrl == "" && !found && location.undefined
}

