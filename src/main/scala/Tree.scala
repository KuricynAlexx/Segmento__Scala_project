class Tree() {
  def createTree(points: List[Point]): Seq[Node] = {
    // to_build nodes without parent (with reserved value of 'parentId': "no_parents"
    var all_points = points
    for (point <- points
         if(points.count(_.id == point.parentId))==0) {
      all_points = all_points.:::(List(Point(point.parentId)))
    }
    all_points = all_points.distinct

    var node_seq: List[Node] = List()
    for (point <- all_points
         if(all_points.count(_.id == point.id) == 1 && point.id!="no_parent")) {
      val node = Node(point, all_points.filter( _.parentId == point.id ))
      node_seq = node_seq.:::(List( node ))
    }
    node_seq
  }
}