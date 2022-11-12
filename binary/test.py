import json

output_documents = []
for i in range(661):
    tmp = []
    with open(r"E:\NLP_Project\UKyoto_UTokyo\dialog_seg\graphseg\binary\data\output\test" + str(i) + '.txt', 'r', encoding="utf-8") as rf:
        for line in rf:
            line=line.strip()
            tmp.append(line)
    output_documents.append(tmp)

input_documents = []
for i in range(661):
    tmp = []
    with open(r"E:\NLP_Project\UKyoto_UTokyo\dialog_seg\graphseg\binary\data\input\test" + str(i) + '.txt', 'r', encoding="utf-8") as rf:
        for line in rf:
            line=line.strip()
            tmp.append(line)
    input_documents.append(tmp)

res = []
for i in range(661):
    tmp = [0] * len(input_documents[i])
    count = 0
    for j in range(len(output_documents[i])-1):
        if output_documents[i][j] == "==========":
            tmp[j-1-count] = 1
            count += 1
    res.append(tmp)

with open("cutlist_graphSeg.json", 'w') as wf:
    wf.write(json.dumps(res, ensure_ascii=False))

