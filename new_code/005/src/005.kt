fun <T> getType(item: T): String? {
    var type : String? = null
    item?.let{type= it::class.simpleName}
    return type
}

open class  AdminUser
{

}

class User : AdminUser()
{

}