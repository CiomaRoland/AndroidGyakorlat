package data_class

data class Date(val year: Int, val month: Int, val day: Int): Comparable<Date>{
    override fun toString(): String {
        return "${this.year}. ${this.month}. ${this.day}"
    }
    override fun compareTo(other: Date): Int {
        //ev
        if(year<other.year){
            return -1
        }
        if(year>other.year){
            return 1
        }
        //honap
        if(month<other.month){
            return -1
        }
        if(month>other.month){
            return 1
        }
        //nap
        if(day<other.day){
            return -1
        }
        if(day>other.day){
            return 1
        }
        return 0
    }
}
class ComparatorDate:Comparator<Date>{
    override fun compare(o1: Date?, o2: Date?): Int {
        if(o1 == null || o2 == null){
            return 0;
        }
        return o1.compareTo(o2)
    }
}
