package util

import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.drodobyte.lostpet.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.squareup.picasso.Picasso
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import drodobyte.android.x.fromDate
import drodobyte.core.util.calendar
import drodobyte.core.util.date
import entity.Location
import presentation.petlocation.PetLocationPresenter.Pos
import java.util.*

fun ImageView.xLoadPetIcon(url: String) =
    Picasso.get()
        .load(if (url.isBlank()) "_undef_" else url)
        .resize(150, 150)
        .centerCrop()
        .error(R.drawable.ic_alert_error)
        .placeholder(R.drawable.ic_downloading)
        .into(this)

fun ImageView.xLoadPet(url: String) =
    Picasso.get()
        .load(if (url.isBlank()) "_undef_" else url)
        .error(R.drawable.ic_alert_error)
        .placeholder(R.drawable.ic_downloading)
        .into(this)

fun FragmentManager.showDateDialog(date: Date, onDateSet: (Date) -> Unit) {
    val now = date.calendar
    DatePickerDialog.newInstance(
        { _, year, month, day ->
            date.time = Triple(year, month, day).date.time
            onDateSet(date)
        },
        now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
    ).show(this, "picker")
}

fun TextView.onClickRunDateDialog(fragmentManager: FragmentManager) {
    setOnClickListener {
        fragmentManager.showDateDialog(text.date) { date ->
            fromDate(date)
        }
    }
}

fun CameraPosition.toPos() =
    Pos(target.latitude, target.longitude, zoom.toDouble())

fun Pos.toLatLon() =
    LatLng(x, y)

fun Location.toPos() = Pos(x, y, z)
