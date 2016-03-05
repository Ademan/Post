Object subclass: #BinTree
	instanceVariableNames: 'leftKid rightKid label'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Binary-Trees'!
!BinTree commentStamp: 'LM 3/3/2016 11:14' prior: 0!
This class represents a node in a binary tree!


!BinTree methodsFor: 'accessors' stamp: 'LM 3/3/2016 16:51'!
getLabel
	"returns the label"
	
	^label! !

!BinTree methodsFor: 'accessors' stamp: 'LM 3/3/2016 11:08'!
getLeftKid
	"returns left kid"
	
	^leftKid! !

!BinTree methodsFor: 'accessors' stamp: 'LM 3/3/2016 11:10'!
getRightKid
	"returns right kid"
	
	^rightKid! !


!BinTree methodsFor: 'initialization' stamp: 'LM 3/3/2016 16:40'!
addLeftKid: newLeftKid
	"add the left kid of this node"

	leftKid := newLeftKid! !

!BinTree methodsFor: 'initialization' stamp: 'LM 3/4/2016 15:31'!
addRightKid: newRightKid
	"add a right kid to this node"

	rightKid := newRightKid! !

!BinTree methodsFor: 'initialization' stamp: 'LM 3/4/2016 14:56'!
setLabel: aLabel
	"set a label for the node"
	label := aLabel! !

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

BinTree class
	instanceVariableNames: ''!

!BinTree class methodsFor: 'construction' stamp: 'LM 3/4/2016 14:54'!
new: label
	"returns new BinTree object with a label"
	
	| node |
	
	node := self new.
	node setLabel: label.
	^node.! !


Object subclass: #InorderTraversal
	instanceVariableNames: 'root stack current'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Binary-Trees'!
!InorderTraversal commentStamp: 'LM 3/3/2016 11:14' prior: 0!
This class performs an in-order traversal of a binary tree!


!InorderTraversal methodsFor: 'traversal' stamp: 'LM 3/4/2016 17:00'!
first
	"print the label of the first node"
	stack push: root.
	
	current := root getLeftKid.
	[current] whileNotNil: [
		stack push: current. 
		current := current getLeftKid.
	].
	
	current := stack pop.
	Transcript show: (current getLabel).
! !

!InorderTraversal methodsFor: 'traversal' stamp: 'LM 3/4/2016 17:00'!
next
	"print label of the next node in the tree"

	
	current := current getRightKid.
	[current] whileNotNil: [
		stack push: current. 
		current := current getLeftKid.
	].

	current := stack pop.
	Transcript show: current getLabel.! !

!InorderTraversal methodsFor: 'traversal' stamp: 'LM 3/4/2016 17:12'!
printFullTraversal
	"prints the full traversal of the tree"
	| done |
	
	self first.
	done := False.
	[done = False] whileTrue:[[self next.] on: Error do: [done := True].].! !


!InorderTraversal methodsFor: 'inititialization' stamp: 'LM 3/4/2016 14:59'!
initializeStack
	"create the stack"
	stack := Stack new! !

!InorderTraversal methodsFor: 'inititialization' stamp: 'LM 3/4/2016 14:52'!
setRoot: aRoot
	" set the root node"
	root := aRoot.! !

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

InorderTraversal class
	instanceVariableNames: ''!

!InorderTraversal class methodsFor: 'construction' stamp: 'LM 3/4/2016 15:00'!
new: root
	"returns new InorderTraversal object with a root node"
	
	| traversal |
	
	traversal := self new.
	traversal setRoot: root.
	traversal initializeStack.
	^traversal
	! !


Object subclass: #Tester
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Binary-Trees'!

!Tester methodsFor: 'testing' stamp: 'LM 3/4/2016 17:14'!
test
	"test cases for inorder binary tree traversal"

	| node1 node2 node3 node4 node5 node6 node7 traversal |

	"test case 1"
	Transcript show: 'Test case 1'.
	Transcript cr.
	Transcript show: 'Expected order:'.
	Transcript cr.
	Transcript show: 'DBEAFCG'.
	Transcript cr.
	Transcript show: 'Actual order:'.
	Transcript cr.
	
	node1 := BinTree new: 'A'.
	node2 := BinTree new: 'B'.
	node3 := BinTree new: 'C'.
	node4 := BinTree new: 'D'.
	node5 := BinTree new: 'E'.
	node6 := BinTree new: 'F'.
	node7 := BinTree new: 'G'.
	node1 addLeftKid: node2.
	node1 addRightKid: node3.
	node2 addLeftKid: node4.
	node2 addRightKid: node5.
	node3 addLeftKid: node6.
	node3 addRightKid: node7.
	
	traversal := InorderTraversal new: node1.
	traversal printFullTraversal.
	Transcript cr.
	
	"test case 2"
	Transcript cr.
	Transcript show: 'Test case 2'.
	Transcript cr.
	Transcript show: 'Expected order:'.
	Transcript cr.
	Transcript show: 'BEAFC'.
	Transcript cr.
	Transcript show: 'Actual order:'.
	Transcript cr.
	
	node1 := BinTree new: 'A'.
	node2 := BinTree new: 'B'.
	node3 := BinTree new: 'C'.
	node4 := BinTree new: 'E'.
	node5 := BinTree new: 'F'.
	node1 addLeftKid: node2.
	node1 addRightKid: node3.
	node2 addRightKid: node4.
	node3 addLeftKid: node5.
	
	traversal := InorderTraversal new: node1.
	traversal printFullTraversal.
	Transcript cr.
	
	"test case 3"
	Transcript cr.
	Transcript show: 'Test case 3'.
	Transcript cr.
	Transcript show: 'Expected order:'.
	Transcript cr.
	Transcript show: 'AFC'.
	Transcript cr.
	Transcript show: 'Actual order:'.
	Transcript cr.
	
	node1 := BinTree new: 'A'.
	node2 := BinTree new: 'C'.
	node3 := BinTree new: 'F'.
	node1 addRightKid: node2.
	node2 addLeftKid: node3.
	
	traversal := InorderTraversal new: node1.
	traversal printFullTraversal.
	Transcript cr.
		
	"test case 4"
	Transcript cr.
	Transcript show: 'Test case 4'.
	Transcript cr.
	Transcript show: 'Expected order:'.
	Transcript cr.
	Transcript show: 'EDCBA'.
	Transcript cr.
	Transcript show: 'Actual order:'.
	Transcript cr.
	
	node1 := BinTree new: 'A'.
	node2 := BinTree new: 'B'.
	node3 := BinTree new: 'C'.
	node4 := BinTree new: 'D'.
	node5 := BinTree new: 'E'.
	node1 addLeftKid: node2.
	node2 addLeftKid: node3.
	node3 addLeftKid: node4.
	node4 addLeftKid: node5.
				
	traversal := InorderTraversal new: node1.
	traversal printFullTraversal.
	Transcript cr.
	
	"test case 5"
	Transcript cr.
	Transcript show: 'Test case 5'.
	Transcript cr.
	Transcript show: 'Expected order:'.
	Transcript cr.
	Transcript show: 'ABCDE'.
	Transcript cr.
	Transcript show: 'Actual order:'.
	Transcript cr.
	
	
	node1 := BinTree new: 'A'.
	node2 := BinTree new: 'B'.
	node3 := BinTree new: 'C'.
	node4 := BinTree new: 'D'.
	node5 := BinTree new: 'E'.
	node1 addRightKid: node2.
	node2 addRightKid: node3.
	node3 addRightKid: node4.
	node4 addRightKid: node5.
	
	
	traversal := InorderTraversal new: node1.
	traversal printFullTraversal.
	Transcript cr.
	
	! !

