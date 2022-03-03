package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task1 extends FunSuite {

  test("cant_change_price & description_not_exact & overcharges_by_one_cent") {
        var testSelfCheckout: SelfCheckout = new SelfCheckout()

        var testItem: Item = new Item("test item", 100.0)

        testSelfCheckout.addItemToStore("123", testItem)
    var descriptions:List[String]=List()
    var prices:List[Double]=List()
    descriptions=descriptions:+"My description"
    prices=prices:+5.99
    descriptions=descriptions:+"Oreos"
    prices=prices:+4.50
    var items:List[Item]=List()
    for (index <- descriptions.indices){
      items=items:+new Item(descriptions(index),prices(index))

      assert(items(index).description()==descriptions(index),"testing description "+ "explected: "+descriptions(index)+" actually got: "+items(index).description())
      assert(Math.abs(items(index).price()-prices(index))<.0001,"testing constructor "+ "expected: "+prices(index)+" got: "+items(index).price())
      items(index).setBasePrice(prices(index)-5)
      assert(Math.abs(items(index).price()-(prices(index)-5))<.0001,"testing setBasePrice "+ "expected: "+(prices(index)-5)+" got: "+items(index).price())
    }

  }

  test("display broken") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem: Item = new Item("test item", 102.0)
    var testItem2: Item = new Item("test item2", 85.0)
    testSelfCheckout.addItemToStore("472", testItem)
    testSelfCheckout.addItemToStore("402", testItem2)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "472")
  }

  test("always adds the same item") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem: Item = new Item("test item", 102.0)
    var testItem2: Item = new Item("test item2", 85.0)
    testSelfCheckout.addItemToStore("472", testItem)
    testSelfCheckout.addItemToStore("402", testItem2)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
//    val invalidItem:Item = new Item("error",0.0)
//    var cart: List[Item] = List()
    assert(testSelfCheckout.itemsInCart() == List(testItem,testItem))
  }

  test("always adds the same item2") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem: Item = new Item("test item", 102.0)
    var testItem2: Item = new Item("test item2", 85.0)
    testSelfCheckout.addItemToStore("472", testItem)
    testSelfCheckout.addItemToStore("402", testItem2)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()

    assert(testSelfCheckout.itemsInCart() == List(testItem,testItem2))
  }

  test("breaks on invalid barcodes") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem: Item = new Item("error", 0.0)
    testSelfCheckout.addItemToStore("472", testItem)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(2)

    testSelfCheckout.enterPressed()

    assert(testSelfCheckout.itemsInCart() == List(testItem))
  }

  test("does not initially display empty") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    assert(testSelfCheckout.displayString() == "")
  }


  //  test("test one") {
  //    var testSelfCheckout: SelfCheckout = new SelfCheckout()
  //    var testItem: Item = new Item("test item", 102.0)
  //    assert(testItem.description() == "test item")
  //    testItem.setBasePrice(85.00)
  //    assert(testItem.price() === 85.00)
  //
  ////    testSelfCheckout.addItemToStore("123", testItem)
  //    testSelfCheckout.numberPressed(123)
  //    assert(testSelfCheckout.displayString() == "123")
  ////    assert(testSelfCheckout.addItemToStore("142",testItem) === Map("142" ->testItem))
  //
  //  }



}
