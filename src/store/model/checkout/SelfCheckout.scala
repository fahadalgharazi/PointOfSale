package store.model.checkout

import store.model.items.Item

class SelfCheckout {

  var itemMap: Map[String,Item] = Map()
  var barCodePressed:String = ""
  val invalidItem:Item = new Item("error",0.0)
  var cart: List[Item] = List()


  def addItemToStore(barcode: String, item: Item): Unit = {
    itemMap = itemMap + (barcode -> item)
    }
  def numberPressed(number: Int): Unit = {
    barCodePressed = barCodePressed + number.toString()
  }

  def clearPressed(): Unit = {
    barCodePressed = ""
  }

  def enterPressed(): Unit = {
    var addingItem = itemMap.getOrElse(barCodePressed,invalidItem)
    barCodePressed = ""
    cart = cart:+ addingItem
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
    barCodePressed
  }

  def itemsInCart(): List[Item] = {
      cart
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
    val testItem: Item = new Item("test item", 100.0)
    addItemToStore("472", testItem)
  }

}
