package store.model.checkout

import store.model.items.Item

class SelfCheckout {


  var itemMap: Map[String,List[String]] = Map()
//    Map(barcode -> item)
//  }

  def addItemToStore(barcode: String, item: Item): Unit = {
//def addItemToStore(barcode: String, item: Item) = {

  // This method adds an item to your store's checkout system. It does not add an item to the customer's cart
//    val newItem: Item = new Item("172",)
    //addes a new item object with a bar code key and an item object
//    object newItem{
      itemMap = itemMap + (barcode -> List(item.itemDescription,(item.Itemprice).toString))

    }
  var numbersPressed = ""
  def numberPressed(number: Int): Unit = {
    this.numbersPressed = this.numbersPressed + number.toString()
  }

  def clearPressed(): Unit = {
  this.numbersPressed = ""
  }

  def enterPressed(): Unit = {
//    this.numbersPressed = ""
    itemsInCart()
  }

  def checkoutPressed(): Unit = {
    // TODO
  }

  def cashPressed(): Unit = {
    // TODO
  }

  def creditPressed(): Unit = {
    // TODO
  }

  def loyaltyCardPressed(): Unit = {
    // TODO
  }

  def displayString(): String = {
    this.numbersPressed
  }
//If a customer enters a barcode that has not been added via addItemToStore, an item with a description of "error" and a price of 0.0 should be added to their cart. Example: if the customer presses "1" "5" "enter" and there’s no item with a barcode "15" then their cart should contain an item with description "error" and price "$0.0"
  def itemsInCart(): List[Item] = {
//    Item(var itemDescription:String, var Itemprice:Double)
    var addingItem = itemMap.getOrElse(this.numbersPressed, List("error","$0.0"))
    addingItem

  }

  def subtotal(): Double = {
    0.0
  }

  def tax(): Double = {
    0.0
  }

  def total(): Double = {
    0.0
  }

  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.

    // Example usage:
    //val testItem: Item = new Item("test item", 100.0)
    //this.addItemToStore("472", testItem)
  }

}
