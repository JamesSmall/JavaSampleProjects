//----------------------------------------------------------------------------
// UnboundedStackInterface.java       by Dale/Joyce/Weems            Chapter 3
//
// Interface for a class that implements a stack of <T> with no bound
// on the size of the stack. A stack is a last-in, first-out structure.
// COPIED FROM THE BOOK to be used in homwork assignments
//----------------------------------------------------------------------------

package ch03.stacks;

public interface UnboundedStackInterface<T> extends StackInterface<T>

{
  void push(T element);
  // Places element at the top of this stack.

}
