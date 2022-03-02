package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task1 extends FunSuite {

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

  test("piazza") {
        var testSelfCheckout: SelfCheckout = new SelfCheckout()
    //
        var testItem: Item = new Item("test item", 100.0)
    //
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

  test("test") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem: Item = new Item("test item", 102.0)
    var testItem2: Item = new Item("test item2", 85.0)
    testSelfCheckout.addItemToStore("472", testItem)
    testSelfCheckout.addItemToStore("402", testItem2)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "472")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart().head.itemDescription == testItem.description())
  }

  test("test1") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem: Item = new Item("test item", 102.0)
//    var testItem2: Item = new Item("test item2", 85.0)
    testSelfCheckout.addItemToStore("472", testItem)
//    testSelfCheckout.addItemToStore("402", testItem2)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "472")
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "472")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart()(0).itemDescription == testItem.description())
    assert(testSelfCheckout.itemsInCart()(1).itemDescription == testItem.description())

  }





}
