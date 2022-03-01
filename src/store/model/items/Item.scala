package store.model.items

class Item(var itemDescription:String, var Itemprice:Double) {

  // TODO: Complete this class according to the features listed in the HW document

  def description(): String = {
    itemDescription
  }

  def setBasePrice(newPrice: Double): Unit ={
    //changes the base price of the item
    this.Itemprice = newPrice
  }

  def price(): Double = {
    Itemprice
//    0.0
  }


}

//class descriptionConstructor(var description:String, var price:Double){
//
//}
