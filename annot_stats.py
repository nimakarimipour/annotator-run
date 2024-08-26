import sys

def roundd(num):
    print(num)
    # to two decimal places
    return "{:.2f}".format(num)

def remain():
    annots_post = open("annots_post.tsv", "r").readlines()
    annots_post = [x.strip() for x in annots_post]
    
    annots_infer = open("annots_infer.tsv", "r").readlines()
    annots_infer = [x.strip() for x in annots_infer]
    
    # Find annotations that are both annots_post and in annots_infer
    both = set(annots_post).intersection(annots_infer)
    print(len(both) + " (" + str(roundd(len(both) / len(annots_infer) * 100)) + "%)")
    

def recall():
    annots_post = open("annots_post.tsv", "r").readlines()
    annots_post = [x.strip() for x in annots_post]
    
    annots_infer = open("annots_infer.tsv", "r").readlines()
    annots_infer = [x.strip() for x in annots_infer]
    
    # calculate recall
    recall = len(set(annots_post).intersection(annots_infer)) / len(annots_post)
    print("Recall: " + str(roundd(recall * 100)) + "%")


def precision():
    annots_post = open("annots_post.tsv", "r").readlines()
    annots_post = [x.strip() for x in annots_post]
    
    annots_infer = open("annots_infer.tsv", "r").readlines()
    annots_infer = [x.strip() for x in annots_infer]
    
    # calculate precision
    precision = len(set(annots_post).intersection(annots_infer)) / len(annots_infer)
    print("Precision: " + str(roundd(precision * 100)) + "%")
    
    
if __name__ == "__main__":
    arg = sys.argv[1]
    if arg == "remain":
        remain()
    elif arg == "recall":
        recall()
    elif arg == "precision":
        precision()
    else:
        print("Invalid argument. Please use 'remain', 'recall', or 'precision'")