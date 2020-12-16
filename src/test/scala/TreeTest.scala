class TreeTest extends org.scalatest.FunSuite {
/* ВАЖНАЯ МАРКА: если в наборе вершин(id, ParentId) есть вершина с ParentID* таким,
   что его непосредственно нет в данном наборе (с таким ID), то будет создана новая вершина в наборе
   без указания родительской Point(id=ParentID*, "no_parent")
   "no_parent" -- зарезервированный ParentId

   Если в наборе вершин есть две вершины с одинаковым ID -- то они исключаются из этого набора.
 */

  test("testCreateTree") {
    val tree = new Tree()

    // #1 Just test
    val point0 = Point("801", "415")
    val point2 = Point("808", "315")

    var point_seq = List(point0, point2)
    var res = tree.createTree(point_seq)
    assert( res.toSet == Set(
      Node(Point("801", "415"),
          List()),
      Node(Point("808", "315"),
          List()),
      Node(Point("415", "no_parent"),
          List(Point("801","415"))),
      Node(Point("315", "no_parent"),
          List(Point("808","315")))
      )
    )

    // #2 Parent <-> child
    val point1 = Point("801", "415")
    val point4 = Point("405", "801")
    val point6 = Point("413", "405")
    val point3 = Point("013", "413")

    point_seq = List(point1, point4, point6, point3)
    res = tree.createTree(point_seq)
    assert( res.toSet == Set(
      Node(Point("801", "415"),
        List(Point("405", "801"))),
      Node(Point("405", "801"),
        List(Point("413", "405"))),
      Node(Point("413", "405"),
        List(Point("013", "413"))),
      Node(Point("013", "413"),
        List()),
      Node(Point("415", "no_parent"),
        List(Point("801", "415")))
      )
    )

    // #3: The same parent
    val point7 = Point("333", "413")
    val point8 = Point("222", "413")
    val point9 = Point("111", "413")

    point_seq = List(point7, point8, point9)
    res = tree.createTree(point_seq)
    assert( res.toSet == Set(
      Node(Point("333", "413"),
        List()),
      Node(Point("222", "413"),
        List()),
      Node(Point("111", "413"),
        List()),
      Node(Point("413", "no_parent"),
        List(Point("333", "413"),
             Point("222", "413"),
             Point("111", "413")))
      )
    )
    // #4: No-parent test
    val point10 = Point("001", "no_parent")
    val point11 = Point("002", "no_parent")
    val point12 = Point("003", "no_parent")

    point_seq = List(point10, point11, point12)
    res = tree.createTree(point_seq)
    assert( res.toSet == Set(
      Node(Point("001", "no_parent"),
        List()),
      Node(Point("002", "no_parent"),
        List()),
      Node(Point("003", "no_parent"),
        List())
      )
    )
  }

}
