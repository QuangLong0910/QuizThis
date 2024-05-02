package quanglong.ph27075.gceagle.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "User")
class Account(
    @ColumnInfo(name = "Username") var username: String = "",
    @ColumnInfo(name = "Password_user") var password: String = "",
    @ColumnInfo(name = "Full_name ") var fullname: String = "",
    @ColumnInfo(name = "Date") var ngaytao: String = "",
    @ColumnInfo(name = "IsAdmin") var isadmin: Boolean = false,
    @ColumnInfo(name = "IsActive") var isactive: Boolean = false,
):Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}