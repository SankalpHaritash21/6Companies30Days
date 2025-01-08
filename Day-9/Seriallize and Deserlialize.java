public class Codec {
    // Initializing our marker as the max possible int value
    private static final String MARKER = "M";
    private static int m = 1;

    private static void serializeRec(TreeNode node, List<String> stream) {
        // Adding marker to stream if the node is null
        if (node == null) {
            String s = Integer.toString(m);
            stream.add(MARKER + s);
            m = m + 1;
            return;
        }

        // Adding node to stream
        stream.add(String.valueOf(node.val));

        // Doing a pre-order tree traversal for serialization
        serializeRec(node.left, stream);
        serializeRec(node.right, stream);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> stream = new ArrayList<>();
        serializeRec(root, stream);
        return String.join(",", stream);
    }

    public static TreeNode deserializeHelper(List<String> stream) {
        // pop last element from list
        String val = stream.remove(stream.size() - 1);

        // Return null when a marker is encountered
        if (val.charAt(0) == MARKER.charAt(0)) {
            return null;
        }

        // Creating new Binary Tree Node from current value from stream
        TreeNode node = new TreeNode(Integer.parseInt(val));

        // Doing a pre-order tree traversal for deserialization
        node.left = deserializeHelper(stream);
        node.right = deserializeHelper(stream);

        // Return node if it exists
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split the string by commas to recreate the list
        List<String> stream = new ArrayList<>(Arrays.asList(data.split(",")));
        // Reverse the list to deserialize correctly
        Collections.reverse(stream);
        TreeNode node = deserializeHelper(stream);
        return node;
    }

}
